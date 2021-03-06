package uk.co.jakebreen.pokecart.ui.shop

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val shopActivityModule = module {
    scope(named<ShopActivity>()) {
        factory { resources() }
        viewModel { ShopViewModel(get(), get(), get(), get()) }
    }
}

fun resources() = ShopItemResources()