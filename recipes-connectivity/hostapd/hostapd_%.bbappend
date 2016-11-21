FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://wired.network \
"

SYSTEMD_AUTO_ENABLE_${PN} = "disable"

do_install_append() {
        if [ -e ${D}${sysconfdir}/hostapd.conf ] ; then
                sed -i -e 's|# driver=hostap|driver=nl80211|' \
                    -e 's|ssid=test|ssid=hiphonix|' \
                    ${D}${sysconfdir}/hostapd.conf
        fi

        # Fix race condition concerning Wi-Fi interface not having been
        # brought up by systemd-networkd
        if [ -e ${D}/${systemd_unitdir}/system/${PN}.service ] ; then
                sed -i -e 's|^After=.*|BindsTo=sys-subsystem-net-devices-wlan0.device\\\nAfter=sys-subsystem-net-devices-wlan0.device|' \
                    ${D}${systemd_unitdir}/system/${PN}.service
        fi

        # Network configuration for hostapd's Wi-Fi interface
        install -d ${D}${sysconfdir}/systemd/network
        # install -m 0644 ${WORKDIR}/hostapd.network ${D}${sysconfdir}/systemd/network/hostapd.network
        install -m 0644 ${WORKDIR}/wired.network ${D}${sysconfdir}/systemd/network/wired.network
}
