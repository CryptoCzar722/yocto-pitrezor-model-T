SUMMARY = "fbcp-ili9341 application"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE.txt;md5=e07269cd84249a454c5d152cf5176dd5"

DEPENDS = "vc-graphics-libonly"
RDEPENDS:${PN} = "vc-graphics-libonly"

SRC_URI = "git://github.com/juj/fbcp-ili9341.git;branch=master \
           file://start_mirrorhdmi \
          "

SRCREV = "98e7a58ca2ea4fa316a15c3190560287a38a3eed"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = "-DWAVESHARE_ST7789VW_HAT=ON -DGPIO_TFT_DATA_CONTROL=22 -DGPIO_TFT_RESET_PIN=27 -DSPI_BUS_CLOCK_DIVISOR=6 -DSTATISTICS=0"

do_install() {
    install -d ${D}${bindir}
    install -m 0766 ${B}/fbcp-ili9341 ${D}${bindir}
    install -m 0755 ${WORKDIR}/start_mirrorhdmi ${D}${bindir}
}
