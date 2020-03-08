cd server
docker build . -t sandbox:server
cd ../mock-server
docker build . -t sandbox:mock-server