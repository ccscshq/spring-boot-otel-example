# spring-boot-otel-example

## How to use

### Build your app

```shell
make docker_build_arm64
```

or

```shell
make docker_build_x86_64
```

### Set environment variables

```shell
DD_SITE={your_dd_site} # e.g. ap1.datadoghq.com
DD_API_KEY={your_dd_api_key}
```

### Start your app and otel collector using Docker Compose

```shell
docker compose up
```
