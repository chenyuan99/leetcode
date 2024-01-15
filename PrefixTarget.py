# Ex: target = "ababaaac", prefix = "abc" -> return true // "ab" + "ab" + "a" + "a" + "ac"

# Ex: target = "abac", prefix = "ab" -> return false // "ac" is not a valid split since "ac" != "ab", 
# need to further split, however, "ac" cannot be split into "a" + "c"