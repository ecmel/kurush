## CLI

mn create-app kurush --jdk=11 -f data-jdbc -f flyway -f graalvm -f jdbc-hikari -f management -f postgres -f security-session -f shade -f views-pebble

## Docker

docker run --name postgres -p 5432:5432  -e POSTGRES_PASSWORD=0000 -d postgres:12

psql -h localhost -p 5432 -U postgres -W
