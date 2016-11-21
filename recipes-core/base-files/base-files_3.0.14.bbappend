hostname="hiphonix"

# Angstrom reverts yocto fix for setting hostname.
# It uses ${MACHINE} instead.
do_install_append () {
  echo ${hostname} > ${D}${sysconfdir}/hostname
}
