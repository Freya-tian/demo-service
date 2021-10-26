package com.itmo.microservices.demo.notifications.api.service

import com.itmo.microservices.demo.tasks.api.model.TaskModel
import com.itmo.microservices.demo.users.api.model.AppUserModel
import com.itmo.microservices.demo.order.api.model.OrderModel
import com.itmo.microservices.demo.payments.api.model.DeliveryModel
import com.itmo.microservices.demo.payments.api.model.PaymentModel

interface NotificationService {
    fun processNewUser(user: AppUserModel)
    fun processAssignedTask(task: TaskModel)
    fun processPayment(payment:PaymentModel)
}