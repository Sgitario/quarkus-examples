#!/bin/bash
# https://github.com/olivergondza/bash-strict-mode
set -eEuo pipefail
trap 's=$?; echo >&2 "$0: Error on line "$LINENO": $BASH_COMMAND"; exit $s' ERR
trap 'kill $(jobs -p) 2>/dev/null' SIGINT SIGTERM EXIT

LOG=$(mktemp /tmp/maven-XXXXX.log)

function txTest() {
    name="$1"
    echo
    echo "Testing $name"
    curl -X POST "http://localhost:8080/api/authors/${name}"
    sleep 5
    books=$(curl -s http://localhost:8080/api/books)
    echo "Books: $books"

    if [ "$books" == "$2" ]; then
        echo "Success - $name book record"
    else
        echo "Failure - $name book record"
        exit 1
    fi

    authors=$(curl -s http://localhost:8080/api/authors)
    echo "Authors: $authors"
    if [ "$authors" == "$3" ]; then
      echo "Success - $name author record"
    else
        echo "Failure - $name author record"
        exit 1
    fi

}

mvn quarkus:dev > $LOG &

while ! grep -q -m1 'Live Coding activated' < $LOG; do
    sleep 2
done

tmux splitw tail -f $LOG

case "$1" in
  al)
    txTest "Al" '[{"id":1,"title":"Al-book1"}]' '[{"name":"Al"},{"name":"Jose"}]'
    ;;
  jose)
    txTest "Jose" '[]' '[{"name":"Jose"}]'
    ;;
  jack)
    txTest "Jack" '[]' '[{"name":"Jose"}]'
    ;;
  all)
    txTest "Al" '[{"id":1,"title":"Al-book1"}]' '[{"name":"Al"},{"name":"Jose"}]'
    txTest "Jose" '[{"id":1,"title":"Al-book1"}]' '[{"name":"Al"},{"name":"Jose"}]'
    txTest "Jack" '[{"id":1,"title":"Al-book1"}]' '[{"name":"Al"},{"name":"Jose"}]'
    ;;
  *)
    echo "Use 'al', 'jose', 'jack', or 'all'"
    ;;
esac
