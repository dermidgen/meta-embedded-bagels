FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://main.conf \
    file://settings \
"

do_install_append() {
  install -d ${D}${sysconfdir}/connman/
  install -m 0644 ${WORKDIR}/main.conf ${D}${sysconfdir}/connman/
	install -d ${D}/${localstatedir}/lib/connman/
  install -m 0644 ${WORKDIR}/settings ${D}/${localstatedir}/lib/connman/

        # Disable DNS proxy otherwise interfering with dnsmasq
        if [ -e ${D}/${systemd_unitdir}/system/${PN}.service ] ; then
                sed -i -e 's|^ExecStart=.*|ExecStart=${sbindir}/${PN}d -n --nodnsproxy|' \
                    ${D}${systemd_unitdir}/system/${PN}.service
        fi
}
