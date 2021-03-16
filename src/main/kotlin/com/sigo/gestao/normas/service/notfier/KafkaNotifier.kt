package com.sigo.gestao.normas.service.notfier

interface KafkaNotifier {

    fun notify(topicName: String, data: Any)
}