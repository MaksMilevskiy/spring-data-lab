package ua.kpi.its.lab.data.svc.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ua.kpi.its.lab.data.entity.File
import ua.kpi.its.lab.data.entity.MobilePhone
import ua.kpi.its.lab.data.repo.FileRepository
import ua.kpi.its.lab.data.repo.MobilePhoneRepository
import ua.kpi.its.lab.data.svc.MobilePhoneService

@Service
class MobilePhoneServiceImpl @Autowired constructor(
    private val repository: MobilePhoneRepository
): MobilePhoneService {
    override fun create(mobilePhone: MobilePhone): MobilePhone {
        if (mobilePhone.id != -1L && repository.existsById(mobilePhone.id)) {
            throw IllegalArgumentException("MobilePhone with ID = ${mobilePhone.id} already exists")
        }
        return repository.save(mobilePhone)
    }

    override fun read(): List<MobilePhone> {
        return repository.findAll()
    }

    override fun readByIndex(index: Int): MobilePhone {
        return this.read()[index]
    }

    override fun update(mobilePhone: MobilePhone): MobilePhone {
        if (!repository.existsById(mobilePhone.id)) {
            throw IllegalArgumentException("MobilePhone with ID = ${mobilePhone.id} not found")
        }
        return repository.save(mobilePhone)
    }

    override fun delete(mobilePhone: MobilePhone) {
        if (!repository.existsById(mobilePhone.id)) {
            throw IllegalArgumentException("MobilePhone with ID = ${mobilePhone.id} not found")
        }
        repository.deleteById(mobilePhone.id)
    }

    override fun deleteByIndex(index: Int): MobilePhone {
        val target = this.readByIndex(index)
        this.delete(target)
        return target
    }
}