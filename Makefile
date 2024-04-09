.PHONY: default
default:
	cat Makefile

.PHONY: docker_inspect
docker_inspect:
	docker inspect spring-boot-otel-example.ccscshq | jq .

.PHONY: docker_build_x86_64
docker_build_x86_64:
	docker buildx build --platform=linux/x86_64 . --load --tag spring-boot-otel-example.ccscshq

.PHONY: docker_build_arm64
docker_build_arm64:
	docker buildx build --platform=linux/arm64 . --load --tag spring-boot-otel-example.ccscshq
