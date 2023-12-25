package com.munene.kobweb.blog.data

import com.mongodb.client.model.Filters
import com.munene.kobweb.blog.models.User
import com.munene.kobweb.blog.util.Constants.DATABASE_NAME
import com.varabyte.kobweb.api.data.add
import com.varabyte.kobweb.api.init.InitApi
import com.varabyte.kobweb.api.init.InitApiContext
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.litote.kmongo.reactivestreams.KMongo
import org.litote.kmongo.reactivestreams.getCollectionOfName

@InitApi
fun initMongoDb(
    context: InitApiContext
) {
    System.setProperty(
        "org.litote.mongo.test.mapping.service",
        "org.litote.kmongo.serialization.SerializationClassMappingTypeService"
    )
    context.data.add(MongoDB(context))
}
class MongoDB(private val context: InitApiContext): MongoRepository {

    // For testing with a localhost.
    private val client = KMongo.createClient()
    private val dataBase= client.getDatabase(DATABASE_NAME)
    private val userCollection = dataBase.getCollectionOfName<User>("user")
    // For a remote mongo database.
//    private val client = MongoClient.create(System.getenv("MONGODB_URI"))
    override suspend fun checkUserExistence(user: User): User? {
        return try {
            userCollection
                .find(
                    Filters.and(
                        Filters.eq(User::username.name, user.username),
                        Filters.eq(User::password.name, user.password)
                    )
                ).awaitFirstOrNull()
        } catch (e: Exception) {
            context.logger.error(e.message.toString())
            null
        }
    }
}