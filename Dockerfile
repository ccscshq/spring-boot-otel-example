# https://gallery.ecr.aws/docker/library/gradle
FROM public.ecr.aws/docker/library/gradle:8-jdk21 AS builder
WORKDIR /app

COPY . /app/
RUN gradle build -x test

# https://gallery.ecr.aws/docker/library/amazoncorretto
FROM public.ecr.aws/docker/library/amazoncorretto:21-al2023-headless
COPY --from=builder /app/build/libs/otelapp-0.1.0.jar /app.jar
RUN curl -Lo /opentelemetry-javaagent.jar https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar
ENTRYPOINT ["java", "-javaagent:/opentelemetry-javaagent.jar", "-jar", "/app.jar"]
