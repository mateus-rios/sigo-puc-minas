package com.sigo.gestao.normas.service.notfier

import com.sigo.gestao.normas.model.DefaultData

data class KafkaRequest(
       val records: MutableList<Any> = mutableListOf()
) {

    fun addRecord(value: Any) {
        value as DefaultData
        this.records.add(mapOf("value" to value, "key" to value.id))
    }

}