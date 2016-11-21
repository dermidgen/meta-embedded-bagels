FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

do_install_append() {
    if [ -e ${D}/${systemd_unitdir}/system/${PN}.service ] ; then
        sed -i -e 's|^ExecStart=.*|ExecStart=${sbindir}/${PN}|' \
            ${D}${systemd_unitdir}/system/${PN}.service
    fi
}

inherit systemd

SYSTEMD_SERVICE_${PN} = "nginx.service"
