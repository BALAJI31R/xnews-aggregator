FROM gradle:7.4.2-jdk17 AS build

WORKDIR /app
COPY . .
RUN chmod +x gradlew && ./gradlew clean installDist -x test --no-daemon

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app
COPY --from=build /app/app/build/install/app ./

ENTRYPOINT ["./bin/app"]
CMD ["sample_input/user_preferences.json"]
