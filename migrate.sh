#! /bin/bash
case $1 in
    up )
    docker-compose run mysql_helper migrate
    ;;
    down )
    docker-compose run mysql_helper undo
    ;;
    drop )
	docker-compose run mysql_helper clean
    ;;
    info )
	docker-compose run mysql_helper info
    ;;
    seed )
    dumpFile=$(./db/init/csv2sql.sh $2)
    docker-compose exec -T mysql bash -c 'mysql -u $MYSQL_USER -p$MYSQL_PASSWORD $MYSQL_DATABASE' < $dumpFile
    rm $dumpFile
    ;;
esac