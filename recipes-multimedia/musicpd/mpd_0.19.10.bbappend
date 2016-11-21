FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

do_install_append() {
    if [ -e ${D}/${systemd_unitdir}/system/mpd.service ] ; then
        sed -i \
            's/\[Service\]/\[Service\]\nExecStartPre=\/bin\/sleep 2/g' \
            ${D}/${systemd_unitdir}/system/mpd.service
    fi
}

SYSTEMD_SERVICE_${PN} = "mpd.service"
