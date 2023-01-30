## Docker deployment:
cd target
docker build -t backendtask1.0 .

cd ..

docker-compose up

## Reference Documentation

- CRUD Operations for article Service Done
- The project is in MVC architecture
- separation of concerns is done
- Article Request and response are separated with each only responsible for one task either request or response of the APIs.
- Implemented Controller Advic but wasnot able o add more custom exceptions due to time constraints.
- Implemented Swagger for API documentation
- Unable to implement JUnit Test cases due to time constraints.
