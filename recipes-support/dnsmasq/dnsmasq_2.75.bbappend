FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SYSTEMD_AUTO_ENABLE_${PN} = "enable"

do_install_append() {
        # Fix issue with /etc/resolv.conf being a symbolic link pointing to a
        # file in an initially nonexistent directory
        if [ -e ${D}/${systemd_unitdir}/system/${PN}.service ] ; then
                sed -i -e 's|^ExecStart=.*|ExecStart=${bindir}/${PN} --no-resolv --resolv-file= -x /run/dnsmasq.pid|' \
                    ${D}${systemd_unitdir}/system/${PN}.service
        fi
}
