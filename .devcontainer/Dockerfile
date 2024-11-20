FROM mcr.microsoft.com/devcontainers/cpp:1-ubuntu-22.04

ENV DEBIAN_FRONTEND=noninteractive

RUN apt-get update -y && \
    apt-get install -y \
    curl \
    zip \
    unzip \
    bash \
    git \
    jq \
    && rm -rf /var/lib/apt/lists/*

RUN curl -s "https://get.sdkman.io" | bash

ENV SDKMAN_DIR="/root/.sdkman"
ENV PATH="${SDKMAN_DIR}/candidates/java/current/bin:${PATH}"

RUN bash -c "source ${SDKMAN_DIR}/bin/sdkman-init.sh && sdk install java 21-oracle"

RUN java -version
