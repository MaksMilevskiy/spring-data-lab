package ua.kpi.its.lab.data.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "mobile_phones")
class MobilePhone(
    @Column
    var brand: String,

    @Column
    var manufacturer: String,

    @Column
    var model: String,

    @Column
    var memorySize: Int,

    @Column
    var price: Double,

    @Column
    var productionDate: Date,

    @Column
    var dualSim: Boolean,

    @OneToMany(mappedBy = "mobilePhone", cascade = [CascadeType.ALL])
    var files: MutableList<File> = mutableListOf()
) : Comparable<MobilePhone> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = -1

    override fun compareTo(other: MobilePhone): Int {
        val equal = this.model == other.model && this.memorySize == other.memorySize
        return if (equal) 0 else 1
    }

    override fun toString(): String {
        return "MobilePhone(brand=$brand, model=$model, memorySize=$memorySize)"
    }
}

@Entity
@Table(name = "files")
class File(
    @Column
    var name: String,

    @Column
    var extension: String,

    @Column
    var size: Long,

    @Column
    var creationDate: Date,

    @Column
    var isPhoto: Boolean,

    @ManyToOne
    @JoinColumn(name = "mobile_phone_id", referencedColumnName = "id")
    var mobilePhone: MobilePhone
) : Comparable<File> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = -1

    override fun compareTo(other: File): Int {
        val equal = this.name == other.name && this.size == other.size
        return if (equal) 0 else 1
    }

    override fun toString(): String {
        return "File(name=$name, extension=$extension, size=$size)"
    }
}