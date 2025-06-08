package com.smartdev.incorpfounds.game.dataStore

import com.smartdev.incorpfounds.game.manager.DataStoreManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

class DS_TestProgressData(override val coroutine: CoroutineScope): DataStoreJsonUtil<List<Int>>(
    serializer   = ListSerializer(Int.serializer()),
    deserializer = ListSerializer(Int.serializer()),
) {

    override val dataStore = DataStoreManager.TestProgress

    override val flow = MutableStateFlow(List(4) { -1 })

}
