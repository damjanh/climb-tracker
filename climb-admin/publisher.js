
const amqp = require('amqplib');

const sendRoute = async (route) => {
  try {
    const connection = await amqp.connect('amqp://rabbitmq:5672');
    const channel = await connection.createChannel();
    await channel.assertQueue('route');
    await channel.sendToQueue('route', Buffer.from(JSON.stringify(route)));
    console.log('Sent route to RabbitMQ');
    await channel.close();
    await connection.close();
  } catch (err) {
    console.log(err);
  }
}

module.exports = sendRoute;