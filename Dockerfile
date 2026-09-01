FROM  eclipse-temurin:17-jdk as builder

WORKDIR /build

COPY . .

RUN javac Main.java


FROM eclipse-temurin:17-jre-alpine

WORKDIR /app



COPY --from=builder /build/*.class ./

CMD ["java", "Main"]
