# BasicSecurityUi

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 8.3.20.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).

#Create Docker Image

## Create Dockerfile

````
# Stage 1
FROM node:12.16.1-alpine As builder
WORKDIR /usr/src/app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

# Stage 2
FROM nginx:1.15.8-alpine
COPY --from=builder /usr/src/app/dist/basic-security-ui/ /usr/share/nginx/html
COPY ./nginx.conf /etc/nginx/conf.d/default.conf
````

## Create Docker ignore

````
.git
node_modules

````
## Build Docker image by default build latest

````
docker build . -t falcon007/basic-security-ui
````

## Running the docker image

````
docker run -p 4040:80 falcon007/basic-security-ui
````

### Push docker images

```bash
docker login
$ docker push falcon007/basic-security-ui
```
