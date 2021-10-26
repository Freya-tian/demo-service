package com.itmo.microservices.demo.products.impl.logging

import com.itmo.microservices.commonlib.logging.NotableEvent
import java.awt.GraphicsConfigTemplate

enum class ProductsServiceNotableEvents(private val template: String):NotableEvent {
    EVENT_PRODUCTS_GOT("Got all products");

    override fun getTemplate(): String {
        return template
    }

    override fun getName(): String {
        return name
    }
}