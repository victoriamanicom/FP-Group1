
FROM node:14

WORKDIR /usr/src/app
COPY . .

Run npm ci --only=production
EXPOSE 3000
ENTRYPOINT ["npm", "start"]
