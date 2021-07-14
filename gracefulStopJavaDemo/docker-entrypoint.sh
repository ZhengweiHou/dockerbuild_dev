#!/bin/bash
function gracefulShutdown {
    echo "Shutting down!!"
    ps -ef | grep KillTest | grep -v -e grep -e 'docker-entrypoint.sh' | awk '{print $2}' | xargs kill

    for i in $(seq 1 5)
    do
        echo "entrypoint shutting down wait $i"
        sleep 1
    done
}

trap gracefulShutdown SIGTERM

exec "$@" &
wait
