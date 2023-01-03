package org.nba.user

import org.apache.commons.lang.builder.HashCodeBuilder

class NbaUserNbaRole implements Serializable {

	private static final long serialVersionUID = 1

	NbaUser nbaUser
	NbaRole nbaRole

	boolean equals(other) {
		if (!(other instanceof NbaUserNbaRole)) {
			return false
		}

		other.nbaUser?.id == nbaUser?.id &&
		other.nbaRole?.id == nbaRole?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (nbaUser) builder.append(nbaUser.id)
		if (nbaRole) builder.append(nbaRole.id)
		builder.toHashCode()
	}

	static NbaUserNbaRole get(long nbaUserId, long nbaRoleId) {
		NbaUserNbaRole.where {
			nbaUser == NbaUser.load(nbaUserId) &&
			nbaRole == NbaRole.load(nbaRoleId)
		}.get()
	}

	static boolean exists(long nbaUserId, long nbaRoleId) {
		NbaUserNbaRole.where {
			nbaUser == NbaUser.load(nbaUserId) &&
			nbaRole == NbaRole.load(nbaRoleId)
		}.count() > 0
	}

	static NbaUserNbaRole create(NbaUser nbaUser, NbaRole nbaRole, boolean flush = false) {
		def instance = new NbaUserNbaRole(nbaUser: nbaUser, nbaRole: nbaRole)
		instance.save(flush: flush, insert: true)
		instance
	}

	static boolean remove(NbaUser u, NbaRole r, boolean flush = false) {
		if (u == null || r == null) return false

		int rowCount = NbaUserNbaRole.where {
			nbaUser == NbaUser.load(u.id) &&
			nbaRole == NbaRole.load(r.id)
		}.deleteAll()

		if (flush) { NbaUserNbaRole.withSession { it.flush() } }

		rowCount > 0
	}

	static void removeAll(NbaUser u, boolean flush = false) {
		if (u == null) return

		NbaUserNbaRole.where {
			nbaUser == NbaUser.load(u.id)
		}.deleteAll()

		if (flush) { NbaUserNbaRole.withSession { it.flush() } }
	}

	static void removeAll(NbaRole r, boolean flush = false) {
		if (r == null) return

		NbaUserNbaRole.where {
			nbaRole == NbaRole.load(r.id)
		}.deleteAll()

		if (flush) { NbaUserNbaRole.withSession { it.flush() } }
	}

	static constraints = {
		nbaRole validator: { NbaRole r, NbaUserNbaRole ur ->
			if (ur.nbaUser == null) return
			boolean existing = false
			NbaUserNbaRole.withNewSession {
				existing = NbaUserNbaRole.exists(ur.nbaUser.id, r.id)
			}
			if (existing) {
				return 'userRole.exists'
			}
		}
	}

	static mapping = {
		id composite: ['nbaRole', 'nbaUser']
		version false
	}
}
