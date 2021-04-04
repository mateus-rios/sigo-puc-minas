# Estagio 1 - Será responsavel em construir nossa aplicação
FROM node:15.12.0-slim as node
WORKDIR /app
COPY package.json /app/
RUN npm install
COPY ./ /app/
ARG env=prod
RUN npm run build

# Estagio 2 - Será responsavel por expor a aplicação
FROM nginx:alpine
COPY --from=node /app/dist/sigo-interface /usr/share/nginx/html
COPY ./nginx-custom.conf /etc/nginx/conf.d/default.conf