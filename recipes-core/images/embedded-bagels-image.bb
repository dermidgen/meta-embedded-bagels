SUMMARY = "The hiphonix player product image."

IMAGE_INSTALL += " \
    alsa-utils \
    crda \
    dnsmasq \
    lame \
    ffmpeg \
    hostapd \
    iperf3 \
    openssl \
    libmpdclient \
    linux-firmware-ralink \
    linux-firmware-rtl8192cu \
    mpc \
    mpd \
    udev-extra-rules \
    shairport-sync \
    hiphonix \
"

LICENSE = "MIT"

#create the deployment directory-tree
PV = "V1.0"
IMAGE_NAME = "${MACHINE}_hiphonix"
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
