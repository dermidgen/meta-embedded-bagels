DESCRIPTION = "The SoX resampler library"
HOMEPAGE = "http://soxr.sourceforge.net/"
SECTION = "multimedia"

LICENSE = "LGPL"
LIC_FILES_CHKSUM = "file://COPYING.LGPL;md5=8c2e1ec1540fb3e0beb68361344cba7e"

S = "${WORKDIR}/git"
SRCREV = "988f8303c7f30d0db5db3e15bf973e2bdf5c867e"
SRC_URI = "git://github.com/uklauer/soxr.git;protocol=https;branch=master \
"

#inherit cmake

