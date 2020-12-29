redis.replicate_commands()
local result = redis.call('setnx', KEYS[1], KEYS[1])
if (result == 1) then
    result = redis.call('pexpire', KEYS[1], ARGV[1])
end
return result
