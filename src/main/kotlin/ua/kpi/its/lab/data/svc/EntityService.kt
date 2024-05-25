package ua.kpi.its.lab.data.svc

import ua.kpi.its.lab.data.entity.File
import ua.kpi.its.lab.data.entity.MobilePhone

interface MobilePhoneService {
    /**
     * Creates a new MobilePhone record.
     *
     * @param mobilePhone: The MobilePhone instance to be inserted
     * @return: The recently created MobilePhone instance
     */
    fun create(mobilePhone: MobilePhone): MobilePhone
    /**
     * Reads all created MobilePhone records.
     *
     * @return: List of created MobilePhone records
     */
    fun read(): List<MobilePhone>
    /**
     * Reads a MobilePhone record by its index.
     * The order is determined by the order of creation.
     *
     * @param index: The index of MobilePhone record
     * @return: The MobilePhone instance at index
     */
    fun readByIndex(index: Int): MobilePhone
    /**
     * Updates a MobilePhone record data.
     *
     * @param mobilePhone: The MobilePhone instance to be updated (valid id is required)
     * @return: The updated MobilePhone record
     */
    fun update(mobilePhone: MobilePhone): MobilePhone
    /**
     * Deletes a MobilePhone record data.
     *
     * @param mobilePhone: The MobilePhone instance to be deleted (valid `id` is required)
     */
    fun delete(mobilePhone: MobilePhone)
    /**
     * Deletes a MobilePhone record by its index.
     * The order is determined by the order of creation.
     *
     * @param index: The index of MobilePhone record to delete
     * @return: The deleted MobilePhone instance at index
     */
    fun deleteByIndex(index: Int): MobilePhone
}