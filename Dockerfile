FROM openjdk:17
EXPOSE 8080
ADD target/hardik153/share-managment-image.jar hardik153/share-managment-image.jar
ENTRYPOINT ["java",".jar","/hardik153/share-managment-image.jar"]