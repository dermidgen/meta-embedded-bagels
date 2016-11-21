DESCRIPTION = "AirPlay emulator"
HOMEPAGE = "http://www.mafipulation.org/"
SECTION = "multimedia"

LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://LICENSES;md5=eb723b61539feef013de476e68b5c50a"

DEPENDS = "mpd \
          libdaemon \
          popt \
          avahi \
          libconfig \
          alsa-lib \
          openssl \
"

S = "${WORKDIR}/git"
SRCREV = "8d821b7d85ba0465c14050cb9393785342c03229"
SRC_URI = "git://github.com/mikebrady/shairport-sync.git;protocol=https;branch=master"

INITSCRIPT_NAME = "shairport-sync"
INITSCRIPT_PARAMS = "defaults 90 10"
SYSTEMD_SERVICE_${PN} = "shairport-sync.service"

inherit autotools useradd systemd update-rc.d

do_configure() {
  cd ${S}
  autoreconf -fi
  ./configure --with-alsa --with-avahi --with-pipe --with-ssl=openssl --with-metadata --with-systemd --host hiphonix --prefix=/usr
}

do_install() {
  cd ${S}
  make -j 8 DESTDIR=${WORKDIR}/image install
}

#getent group shairport-sync &>/dev/null || sudo groupadd -r shairport-sync >/dev/null
#getent passwd shairport-sync &> /dev/null || sudo useradd -r -M -g shairport-sync -s /usr/bin/nologin -G audio shairport-sync >/dev/null
USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = "-r -M -g shairport-sync -s /usr/bin/nologin -G audio shairport-sync"
GROUPADD_PARAM_${PN} = "-r shairport-sync"
