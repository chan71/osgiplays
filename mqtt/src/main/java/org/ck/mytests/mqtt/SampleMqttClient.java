package org.ck.mytests.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * Created by ck40283 on 10/17/14.
 */

public class SampleMqttClient {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        String topic        = "camel.test";
        String content      = "Message from MqttPublishSample";
        int qos             = 2;
        String broker       = "tcp://iot.eclipse.org:1883";
//        String broker       = "tcp://localhost:1883";
        String clientId     = "JavaSample";
        String clientId2     = "JavaSample2";
        MemoryPersistence persistence = new MemoryPersistence();
        MemoryPersistence persistence2 = new MemoryPersistence();
        MqttClient publisherClient = new MqttClient(broker, clientId, persistence);
        MqttClient subscriberClient = new MqttClient(broker, clientId2, persistence2);

        try {
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: "+broker);
            subscriberClient.connect(connOpts);
            System.out.println("Subscriber Connected");
//
//            //retrieve published message
//            System.out.println("Subscribing to Topic: "+topic);
//            subscriberClient.subscribe(topic);
//            subscriberClient.setCallback(new MqttCallback() {
//                @Override
//                public void connectionLost(Throwable throwable) {
//
//                }
//
//                @Override
//                public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
//                    System.out.println("message payload : " + new String(mqttMessage.getPayload()));
//                    System.out.println("string : " + s);
//                }
//
//                @Override
//                public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
//
//                }
//            });

            System.out.println("Connecting to broker: "+broker);
            publisherClient.connect(connOpts);
            System.out.println("Publisher Connected");

            System.out.println("Publishing message: "+content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            publisherClient.publish(topic, message);
            System.out.println("Message published");
            Thread.sleep(10000);

        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        } finally {
            publisherClient.disconnect();
            subscriberClient.disconnect();
            System.out.println("Disconnected");
            System.exit(0);
        }
    }
}