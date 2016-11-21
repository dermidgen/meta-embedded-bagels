do_deploy_append() {
    # IQaudIO Pi-DAC+ support
    if [ -n "${IQAUDIO_DAC}" ]; then
        echo "# Enable IQaudIO Pi-DAC+" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
        echo "dtoverlay=iqaudio-dacplus" >>${DEPLOYDIR}/bcm2835-bootfiles/config.txt
    fi
}
