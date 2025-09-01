```plain
gg.nextforge.bytestorm
├── common
│   ├── annotations
│   ├── config
│   │   ├── sources
│   │   └── model
│   ├── convert
│   ├── crypto
│   ├── error
│   ├── functional
│   ├── i18n
│   ├── ids
│   ├── json
│   ├── logging
│   ├── net
│   │   ├── http
│   │   ├── rpc
│   │   ├── transport
│   │   └── codec
│   ├── reflect
│   ├── serialize
│   ├── time
│   └── util
│
├── core
│   ├── bootstrap
│   ├── cluster
│   │   ├── discovery
│   │   ├── gossip
│   │   └── membership
│   ├── commands
│   ├── events
│   ├── lifecycle
│   ├── metrics
│   │   ├── exporters
│   │   └── reporters
│   ├── modules
│   │   ├── api
│   │   ├── loader
│   │   └── spi
│   ├── permissions
│   ├── registry
│   ├── scheduler
│   ├── security
│   ├── services
│   ├── state
│   ├── storage
│   │   ├── redis
│   │   ├── mysql
│   │   └── cache
│   ├── templates
│   └── topology
│
├── api
│   ├── groups
│   ├── players
│   ├── servers
│   ├── templates
│   ├── events
│   ├── commands
│   ├── permissions
│   ├── status
│   ├── query
│   └── pagination
│
├── sdk                         # Cross-Platform SDK (Server + Proxy)
│   ├── platform
│   │   ├── api                 # minimal, plattformneutral Facades
│   │   ├── paper
│   │   ├── spigot
│   │   ├── purpur
│   │   ├── folia
│   │   ├── velocity
│   │   ├── bungeecord
│   │   └── minestom
│   ├── context
│   ├── env
│   ├── events
│   │   ├── player
│   │   ├── server
│   │   └── proxy
│   ├── messaging
│   │   ├── bus
│   │   ├── codec
│   │   ├── channel
│   │   └── envelopes
│   ├── services
│   │   ├── player
│   │   ├── server
│   │   ├── proxy
│   │   └── resource
│   ├── commands
│   │   ├── dispatcher
│   │   └── brigadier           # wrapper/shims
│   ├── permissions
│   ├── persistence
│   │   ├── kv
│   │   └── doc
│   ├── scheduling
│   ├── serialization
│   ├── telemetry
│   ├── text
│   ├── ui                      # chat/ui abstractions (titles, bossbar, actionbar)
│   └── util
│
├── bridge
│   ├── common
│   │   ├── config
│   │   ├── events
│   │   ├── messaging
│   │   ├── sync
│   │   └── util
│   ├── velocity
│   │   ├── bootstrap
│   │   ├── listeners
│   │   ├── commands
│   │   ├── adapters            # sdk.platform.velocity Adapter
│   │   └── service
│   ├── proxylegacy             # BungeeCord/Waterfall
│   │   ├── bootstrap
│   │   ├── listeners
│   │   ├── commands
│   │   ├── adapters
│   │   └── service
│   ├── spigot
│   │   ├── bootstrap
│   │   ├── listeners
│   │   ├── commands
│   │   ├── adapters
│   │   └── service
│   ├── paper
│   │   ├── bootstrap
│   │   ├── listeners
│   │   ├── commands
│   │   ├── adapters
│   │   └── service
│   ├── aspaper
│   │   ├── bootstrap
│   │   ├── listeners
│   │   ├── commands
│   │   ├── adapters
│   │   └── service
│   ├── purpur
│   │   ├── bootstrap
│   │   ├── listeners
│   │   ├── commands
│   │   ├── adapters
│   │   └── service
│   ├── folia
│   │   ├── bootstrap
│   │   ├── listeners
│   │   ├── commands
│   │   ├── adapters
│   │   └── service
│   └── minestom
│       ├── bootstrap
│       ├── listeners
│       ├── commands
│       ├── adapters
│       └── service
│
├── controller
│   ├── cli
│   │   ├── args
│   │   ├── commands
│   │   └── tui
│   └── web
│       ├── app
│       ├── auth
│       ├── filters
│       ├── http
│       ├── routes
│       ├── dto
│       ├── ws
│       └── openapi
│
├── agent
│   ├── bootstrap
│   ├── exec
│   ├── heartbeat
│   ├── updater
│   ├── sandbox
│   ├── monitor
│   └── transport
│
└── docs
    ├── api
    ├── architecture
    └── guides

```
