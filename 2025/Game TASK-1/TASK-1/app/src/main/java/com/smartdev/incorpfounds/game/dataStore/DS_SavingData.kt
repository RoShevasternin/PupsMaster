package com.smartdev.incorpfounds.game.dataStore

import com.smartdev.incorpfounds.game.manager.DataStoreManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer

class DS_SavingData(override val coroutine: CoroutineScope): DataStoreJsonUtil<List<DataSaving>>(
    serializer   = ListSerializer(DataSaving.serializer()),
    deserializer = ListSerializer(DataSaving.serializer()),
) {

    override val dataStore = DataStoreManager.Saving

    override val flow = MutableStateFlow(listOf<DataSaving>())

}

@Serializable
data class DataSaving(
    var nName : String,
    var amount: Int,
    var rate  : Int,
    var term  : Int,
    var contr : Int,
)
