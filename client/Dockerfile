FROM node:19.3.0

WORKDIR /app

COPY ["./index.html", "./package.json", "./tsconfig.json", "./webpack.config.js", "./.eslintrc.js", "./"]

COPY ./src ./src

RUN npm install

USER node

# CMD npm run dev