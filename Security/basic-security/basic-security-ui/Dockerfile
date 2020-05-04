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
