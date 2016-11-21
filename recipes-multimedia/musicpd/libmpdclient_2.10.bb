SECTION = "multimedia"
SUMMARY = "A stable, documented, asynchronous API library for interfacing MPD in the C, C++ & Objective C languages"
HOMEPAGE = "http://www.musicpd.org/libs/libmpdclient/"


LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=06b9dfd2f197dc514d8ef06549684b77"

SRC_URI="http://www.musicpd.org/download/libmpdclient/2/${BP}.tar.gz"
SRC_URI[md5sum] = "8aef1e9a3dcb4ed0f1387e5d774b02bc"
SRC_URI[sha256sum] = "bf88ddd9beceadef11144811adaabe45008005af02373595daa03446e6b1bf3d"

EXTRA_OECONF="--disable-documentation"

inherit autotools

do_install_append () {
    find "${D}" -name 'vala' -exec rm -fr {} +
}
