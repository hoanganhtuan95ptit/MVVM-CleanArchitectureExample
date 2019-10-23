package net.lab.myapplication.data.db.realm

import net.lab.myapplication.data.db.ImageDb
import net.lab.myapplication.data.entities.Image

class RealmImageDb : RealmDb<Image>(), ImageDb {
}