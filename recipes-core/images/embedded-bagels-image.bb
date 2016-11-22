SUMMARY = "The embedded-bagels player product image."

IMAGE_INSTALL += " \
    crda \
    dnsmasq \
    hostapd \
    iperf3 \
    openssl \
    udev-extra-rules \
    embedded-bagels \
"

LICENSE = "MIT"

#create the deployment directory-tree
PV = "V1.0"
IMAGE_NAME = "${MACHINE}_embedded-bagels"
require recipes-images/angstrom/systemd-image.bb

# IMAGE_ROOTFS_EXTRA_SPACE = "2000"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = " \
    --groups sudo \
    --user-group ${PN} \
"

#create the file /etc/timestamp
#note: overriding IMAGE_PREPROCESS_COMMAND also gets rid of systemd-networkd
#configuration in favour of connmand by not having angstom-image's
#do_systemd_network() deploying any configuration files to /etc/systemd/network
IMAGE_PREPROCESS_COMMAND = "rootfs_update_timestamp"
