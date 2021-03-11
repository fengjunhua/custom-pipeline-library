#!/bin/bash

while getopts 'O:P:S:T:' OPT; do
    case $OPT in
        O)
            OPERATE="$OPTARG"
            ;;
        P)
            PROJECT_NAME="$OPTARG"
            ;;
        S)
            SERVICE_NAME="$OPTARG"
            ;;
        T)
            IMAGETAG="$OPTARG"
            ;;

    esac
done

echo "$OPERATE"
echo "$PROJECT_NAME"
echo "$SERVICE_NAME"
echo "$IMAGETAG"

cd /root/docker-compose/$PROJECT_NAME/$SERVICE_NAME

case "$OPERATE" in

     deploy)

        sed -i "s/ImageTag=.*/ImageTag=${IMAGETAG}/g" .env

        docker-compose up -d

        ;;

     stop)

        docker-compose stop

        ;;

     start)

        docker-compose start

        ;;

     restart)

        docker-compose stop

        docker-compose start

        ;;

     down)

        docker-compose down

        ;;

     up)

        docker-compose up -d

        ;;

     rollback)

        sed -i "s/ImageTag=.*/ImageTag=${ImageTag}/g" .env

        docker-compose up -d

        ;;

esac
exit 0