package uk.co.jakebreen.pokecart.ui.filter

import androidx.lifecycle.*
import uk.co.jakebreen.pokecart.model.filter.FilterRepository
import uk.co.jakebreen.pokecart.model.stat.Stat
import uk.co.jakebreen.pokecart.model.type.Type

class FilterDialogViewModel(private val filterRepository: FilterRepository): ViewModel() {

    fun observeFilteredTypes() = filterRepository.getFilterTypes()
    fun observeFilteredStats() = filterRepository.getFilterStats()

    fun saveFilters(checkedTypes: Map<Type, Boolean>, health: List<Float>, attack: List<Float>, defense: List<Float>, speed: List<Float>) {
        filterRepository.postFilterTypes(checkedTypes)
        filterRepository.postFilterStats(mapOf(
            Stat.HEALTH to Pair(health[0].toInt(), health[1].toInt()),
            Stat.ATTACK to Pair(attack[0].toInt(), attack[1].toInt()),
            Stat.DEFENSE to Pair(defense[0].toInt(), defense[1].toInt()),
            Stat.SPEED to Pair(speed[0].toInt(), speed[1].toInt())))
    }

}