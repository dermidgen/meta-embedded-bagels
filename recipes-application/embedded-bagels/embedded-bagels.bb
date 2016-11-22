SECTION = "app"
SUMMARY = "The Embedded Bagels Kitchen Sink Application."
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

S = "${WORKDIR}/git"
SRCREV = "${AUTOREV}"
SRC_URI = " \
    git://git@github.com/dermidgen/sama5d4-kitchen-sink.git;protocol=ssh;branch=master \
    file://${PN}.conf \
"

#INITSCRIPT_NAME = "embedded-bagels"
#INITSCRIPT_PARAMS = "defaults 75"

#SYSTEMD_SERVICE_${PN} = "embedded-bagels.service"

#inherit cmake systemd update-rc.d

#do_install_append() {
#        # Install local environment file
#        install -d ${D}${sysconfdir}/default
#        install -m 0644 ${WORKDIR}/${PN}.conf ${D}${sysconfdir}/default/${PN}
#        # Install systemd unit files
#        install -d ${D}${systemd_unitdir}/system
#        install -m 0644 ${S}/contrib/${PN}.service ${D}${systemd_unitdir}/system
#        sed -i -e 's,@BASE_BINDIR@,${base_bindir},g' \
#               -e 's,@SBINDIR@,${sbindir},g' \
#               ${D}${systemd_unitdir}/system/${PN}.service
#}
