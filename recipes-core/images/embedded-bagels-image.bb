SUMMARY = "Embedded Bagels Demo Image"
LICENSE = "MIT"

PV = "V1.0"
IMAGE_NAME = "embedded-bagels-image-${MACHINE}"

IMAGE_FEATURES += "ssh-server-openssh package-management"

DEPENDS_${PN} += " kernel-module-dm-thin-pool kernel-module-nf-nat"
DEPENDS_${PN} += " curl aufs-util git cgroup-lite util-linux iptables"

IMAGE_INSTALL += "\
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    packagegroup-base-wifi \
    packagegroup-base-bluetooth \
    packagegroup-base-usbgadget \
    kernel-modules \
    lrzsz \
    setserial \
    opkg \
    iperf \
    \
    nbench-byte \
    lmbench \
    \
    linux-firmware \
    atmel-wireless-firmware \
    alsa-utils \
    i2c-tools \
    devmem2 \
    dosfstools \
    libdrm-tests \
    mtd-utils \
    mtd-utils-ubifs \
    dtc \
    dtc-misc \
    \
    iproute2 \
    iptables \
    \
    bridge-utils \
    canutils \
    evtest \
    gdbserver \
    usbutils \
    wget \
    \
    packagegroup-base-usbhost \
    \
    docker \
    ${CORE_IMAGE_EXTRA_INSTALL} \
"

# Removed packages
#    python-pyserial
#    python-smbus
#    python-ctypes
#    python-pip
#    python-distribute
#    python-pycurl
#    mpg123


inherit core-image
