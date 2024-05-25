package ua.kpi.its.lab.data

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import ua.kpi.its.lab.data.config.Config
import ua.kpi.its.lab.data.entity.File
import ua.kpi.its.lab.data.entity.MobilePhone
import ua.kpi.its.lab.data.svc.MobilePhoneService
import java.util.Calendar

fun main() {
    val context = AnnotationConfigApplicationContext(Config::class.java)
    val mobilePhoneService = context.getBean(MobilePhoneService::class.java)
    val calendar = context.getBean(Calendar::class.java)

    val mobilePhone1 = MobilePhone(
        "Brand1", "Manufacturer1", "Model1", 32, 500.0,
        calendar.apply { set(2018, 0, 1, 0, 0, 0) }.time, true, mutableListOf()
    )
    val file1 = File("file1", "txt", 1024, calendar.apply { set(2020, 0, 1, 0, 0, 0) }.time, false, mobilePhone1)
    val file2 = File("file2", "jpg", 2048, calendar.apply { set(2021, 0, 1, 0, 0, 0) }.time, true, mobilePhone1)
    mobilePhone1.files.addAll(listOf(file1, file2))

    val mobilePhone2 = MobilePhone(
        "Brand2", "Manufacturer2", "Model2", 64, 800.0,
        calendar.apply { set(2019, 0, 1, 0, 0, 0) }.time, false, mutableListOf()
    )

    val mobilePhone3 = MobilePhone(
        "Brand1", "Manufacturer1", "Model3", 128, 1200.0,
        calendar.apply { set(2020, 0, 1, 0, 0, 0) }.time, true, mutableListOf()
    )
    val file3 = File("file3", "jpg", 4096, calendar.apply { set(2022, 0, 1, 0, 0, 0) }.time, true, mobilePhone3)
    mobilePhone3.files.add(file3)

    val mobilePhones = listOf(mobilePhone1, mobilePhone2, mobilePhone3)
    mobilePhones.forEach { mobilePhoneService.create(it) }

    val mobilePhone2Retrieved = mobilePhoneService.readByIndex(1)
    println("Retrieved mobile phone: $mobilePhone2Retrieved")

    val deletedMobilePhone = mobilePhoneService.deleteByIndex(2)
    println("Removed mobile phone: $deletedMobilePhone")
}